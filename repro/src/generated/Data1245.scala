package generated

final case class Data1245(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1245 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1245 = copy(value = value * k)
  def addTag(t: String): Data1245 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1245 = copy(meta = meta.updated(k, v))
  def merge(other: Data1245): Data1245 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1245 {
  given Ordering[Data1245] = Ordering.by(_.id)
  def empty: Data1245 = Data1245(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1245 =
    Data1245(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1245] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
