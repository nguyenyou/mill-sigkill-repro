package generated

final case class Data646(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data646 = copy(name = name.toUpperCase)
  def scale(k: Double): Data646 = copy(value = value * k)
  def addTag(t: String): Data646 = copy(tags = t :: tags)
  def put(k: String, v: String): Data646 = copy(meta = meta.updated(k, v))
  def merge(other: Data646): Data646 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data646 {
  given Ordering[Data646] = Ordering.by(_.id)
  def empty: Data646 = Data646(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data646 =
    Data646(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data646] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
