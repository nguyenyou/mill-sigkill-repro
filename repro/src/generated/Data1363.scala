package generated

final case class Data1363(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1363 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1363 = copy(value = value * k)
  def addTag(t: String): Data1363 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1363 = copy(meta = meta.updated(k, v))
  def merge(other: Data1363): Data1363 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1363 {
  given Ordering[Data1363] = Ordering.by(_.id)
  def empty: Data1363 = Data1363(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1363 =
    Data1363(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1363] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
