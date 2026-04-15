package generated

final case class Data12(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data12 = copy(name = name.toUpperCase)
  def scale(k: Double): Data12 = copy(value = value * k)
  def addTag(t: String): Data12 = copy(tags = t :: tags)
  def put(k: String, v: String): Data12 = copy(meta = meta.updated(k, v))
  def merge(other: Data12): Data12 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data12 {
  given Ordering[Data12] = Ordering.by(_.id)
  def empty: Data12 = Data12(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data12 =
    Data12(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data12] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
