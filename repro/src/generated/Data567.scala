package generated

final case class Data567(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data567 = copy(name = name.toUpperCase)
  def scale(k: Double): Data567 = copy(value = value * k)
  def addTag(t: String): Data567 = copy(tags = t :: tags)
  def put(k: String, v: String): Data567 = copy(meta = meta.updated(k, v))
  def merge(other: Data567): Data567 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data567 {
  given Ordering[Data567] = Ordering.by(_.id)
  def empty: Data567 = Data567(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data567 =
    Data567(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data567] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
