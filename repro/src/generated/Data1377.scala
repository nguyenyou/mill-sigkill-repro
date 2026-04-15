package generated

final case class Data1377(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1377 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1377 = copy(value = value * k)
  def addTag(t: String): Data1377 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1377 = copy(meta = meta.updated(k, v))
  def merge(other: Data1377): Data1377 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1377 {
  given Ordering[Data1377] = Ordering.by(_.id)
  def empty: Data1377 = Data1377(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1377 =
    Data1377(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1377] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
