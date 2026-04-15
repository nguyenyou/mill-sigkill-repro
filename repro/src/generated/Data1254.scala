package generated

final case class Data1254(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1254 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1254 = copy(value = value * k)
  def addTag(t: String): Data1254 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1254 = copy(meta = meta.updated(k, v))
  def merge(other: Data1254): Data1254 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1254 {
  given Ordering[Data1254] = Ordering.by(_.id)
  def empty: Data1254 = Data1254(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1254 =
    Data1254(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1254] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
