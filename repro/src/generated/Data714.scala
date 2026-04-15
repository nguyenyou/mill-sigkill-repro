package generated

final case class Data714(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data714 = copy(name = name.toUpperCase)
  def scale(k: Double): Data714 = copy(value = value * k)
  def addTag(t: String): Data714 = copy(tags = t :: tags)
  def put(k: String, v: String): Data714 = copy(meta = meta.updated(k, v))
  def merge(other: Data714): Data714 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data714 {
  given Ordering[Data714] = Ordering.by(_.id)
  def empty: Data714 = Data714(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data714 =
    Data714(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data714] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
