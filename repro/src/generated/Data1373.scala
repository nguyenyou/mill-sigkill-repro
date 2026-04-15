package generated

final case class Data1373(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1373 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1373 = copy(value = value * k)
  def addTag(t: String): Data1373 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1373 = copy(meta = meta.updated(k, v))
  def merge(other: Data1373): Data1373 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1373 {
  given Ordering[Data1373] = Ordering.by(_.id)
  def empty: Data1373 = Data1373(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1373 =
    Data1373(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1373] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
