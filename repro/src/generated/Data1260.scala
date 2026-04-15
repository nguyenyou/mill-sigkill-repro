package generated

final case class Data1260(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1260 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1260 = copy(value = value * k)
  def addTag(t: String): Data1260 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1260 = copy(meta = meta.updated(k, v))
  def merge(other: Data1260): Data1260 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1260 {
  given Ordering[Data1260] = Ordering.by(_.id)
  def empty: Data1260 = Data1260(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1260 =
    Data1260(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1260] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
