package generated

final case class Data1197(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1197 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1197 = copy(value = value * k)
  def addTag(t: String): Data1197 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1197 = copy(meta = meta.updated(k, v))
  def merge(other: Data1197): Data1197 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1197 {
  given Ordering[Data1197] = Ordering.by(_.id)
  def empty: Data1197 = Data1197(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1197 =
    Data1197(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1197] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
