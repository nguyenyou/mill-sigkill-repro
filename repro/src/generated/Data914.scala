package generated

final case class Data914(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data914 = copy(name = name.toUpperCase)
  def scale(k: Double): Data914 = copy(value = value * k)
  def addTag(t: String): Data914 = copy(tags = t :: tags)
  def put(k: String, v: String): Data914 = copy(meta = meta.updated(k, v))
  def merge(other: Data914): Data914 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data914 {
  given Ordering[Data914] = Ordering.by(_.id)
  def empty: Data914 = Data914(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data914 =
    Data914(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data914] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
