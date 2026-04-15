package generated

final case class Data1458(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1458 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1458 = copy(value = value * k)
  def addTag(t: String): Data1458 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1458 = copy(meta = meta.updated(k, v))
  def merge(other: Data1458): Data1458 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1458 {
  given Ordering[Data1458] = Ordering.by(_.id)
  def empty: Data1458 = Data1458(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1458 =
    Data1458(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1458] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
