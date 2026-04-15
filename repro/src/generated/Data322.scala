package generated

final case class Data322(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data322 = copy(name = name.toUpperCase)
  def scale(k: Double): Data322 = copy(value = value * k)
  def addTag(t: String): Data322 = copy(tags = t :: tags)
  def put(k: String, v: String): Data322 = copy(meta = meta.updated(k, v))
  def merge(other: Data322): Data322 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data322 {
  given Ordering[Data322] = Ordering.by(_.id)
  def empty: Data322 = Data322(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data322 =
    Data322(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data322] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
