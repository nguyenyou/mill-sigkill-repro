package generated

final case class Data1349(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1349 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1349 = copy(value = value * k)
  def addTag(t: String): Data1349 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1349 = copy(meta = meta.updated(k, v))
  def merge(other: Data1349): Data1349 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1349 {
  given Ordering[Data1349] = Ordering.by(_.id)
  def empty: Data1349 = Data1349(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1349 =
    Data1349(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1349] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
