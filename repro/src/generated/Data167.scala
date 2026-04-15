package generated

final case class Data167(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data167 = copy(name = name.toUpperCase)
  def scale(k: Double): Data167 = copy(value = value * k)
  def addTag(t: String): Data167 = copy(tags = t :: tags)
  def put(k: String, v: String): Data167 = copy(meta = meta.updated(k, v))
  def merge(other: Data167): Data167 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data167 {
  given Ordering[Data167] = Ordering.by(_.id)
  def empty: Data167 = Data167(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data167 =
    Data167(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data167] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
