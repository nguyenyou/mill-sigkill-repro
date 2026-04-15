package generated

final case class Data1286(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1286 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1286 = copy(value = value * k)
  def addTag(t: String): Data1286 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1286 = copy(meta = meta.updated(k, v))
  def merge(other: Data1286): Data1286 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1286 {
  given Ordering[Data1286] = Ordering.by(_.id)
  def empty: Data1286 = Data1286(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1286 =
    Data1286(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1286] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
