package generated

final case class Data402(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data402 = copy(name = name.toUpperCase)
  def scale(k: Double): Data402 = copy(value = value * k)
  def addTag(t: String): Data402 = copy(tags = t :: tags)
  def put(k: String, v: String): Data402 = copy(meta = meta.updated(k, v))
  def merge(other: Data402): Data402 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data402 {
  given Ordering[Data402] = Ordering.by(_.id)
  def empty: Data402 = Data402(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data402 =
    Data402(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data402] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
