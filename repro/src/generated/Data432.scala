package generated

final case class Data432(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data432 = copy(name = name.toUpperCase)
  def scale(k: Double): Data432 = copy(value = value * k)
  def addTag(t: String): Data432 = copy(tags = t :: tags)
  def put(k: String, v: String): Data432 = copy(meta = meta.updated(k, v))
  def merge(other: Data432): Data432 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data432 {
  given Ordering[Data432] = Ordering.by(_.id)
  def empty: Data432 = Data432(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data432 =
    Data432(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data432] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
