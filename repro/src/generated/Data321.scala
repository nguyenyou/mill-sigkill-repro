package generated

final case class Data321(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data321 = copy(name = name.toUpperCase)
  def scale(k: Double): Data321 = copy(value = value * k)
  def addTag(t: String): Data321 = copy(tags = t :: tags)
  def put(k: String, v: String): Data321 = copy(meta = meta.updated(k, v))
  def merge(other: Data321): Data321 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data321 {
  given Ordering[Data321] = Ordering.by(_.id)
  def empty: Data321 = Data321(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data321 =
    Data321(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data321] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
