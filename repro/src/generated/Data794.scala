package generated

final case class Data794(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data794 = copy(name = name.toUpperCase)
  def scale(k: Double): Data794 = copy(value = value * k)
  def addTag(t: String): Data794 = copy(tags = t :: tags)
  def put(k: String, v: String): Data794 = copy(meta = meta.updated(k, v))
  def merge(other: Data794): Data794 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data794 {
  given Ordering[Data794] = Ordering.by(_.id)
  def empty: Data794 = Data794(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data794 =
    Data794(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data794] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
