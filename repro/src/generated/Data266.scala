package generated

final case class Data266(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data266 = copy(name = name.toUpperCase)
  def scale(k: Double): Data266 = copy(value = value * k)
  def addTag(t: String): Data266 = copy(tags = t :: tags)
  def put(k: String, v: String): Data266 = copy(meta = meta.updated(k, v))
  def merge(other: Data266): Data266 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data266 {
  given Ordering[Data266] = Ordering.by(_.id)
  def empty: Data266 = Data266(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data266 =
    Data266(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data266] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
